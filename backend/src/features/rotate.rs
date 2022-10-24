use crate::core::plane::cartesian::cartesian_point::CartesianPoint;
use crate::core::plane::conversions::cartesian_to_polar::cartesian_to_polar;
use crate::core::plane::conversions::polar_to_cartesian::polar_to_cartesian;
use crate::core::plane::plane::Plane;
use crate::core::plane::plane_point::PlanePoint;
use crate::core::plane::polar::rotate::rotate as core_rotate;
use crate::core::precise_decimal::PreciseDecimal;

pub fn rotate(point: PlanePoint, center_of_rotation: CartesianPoint, angle: String) -> PlanePoint {
    match point.plane_type {
        Plane::CARTESIAN => {
            let offset_point = point.to_cartesian() - center_of_rotation.clone();
            let point_as_polar = cartesian_to_polar(offset_point);
            let rotated_point = core_rotate(point_as_polar, PreciseDecimal::from_string(angle));
            let point_as_cartesian = polar_to_cartesian(rotated_point);
            let unoffseted_point = point_as_cartesian + center_of_rotation;

            PlanePoint::from_cartesian(unoffseted_point)
        }
        Plane::POLAR => {
            let offset_point = point.to_cartesian() - center_of_rotation.clone();
            let point_as_polar = cartesian_to_polar(offset_point);
            let rotated_point = core_rotate(point_as_polar, PreciseDecimal::from_string(angle));
            let point_as_cartesian = polar_to_cartesian(rotated_point);
            let unoffseted_point = point_as_cartesian + center_of_rotation;
            let unoffseted_as_polar = cartesian_to_polar(unoffseted_point);

            PlanePoint::from_polar(unoffseted_as_polar)
        }
    }
}

#[cfg(test)]
mod test_rotate {
    use crate::core::precise_decimal::PreciseDecimal;

    use super::*;

    #[test]
    fn polar_rotate() {
        assert_eq!(
            rotate(
                PlanePoint {
                    plane_type: Plane::POLAR,
                    a: "1.22".to_string(),
                    b: "11.11".to_string()
                },
                CartesianPoint {
                    x: PreciseDecimal::from_int(0),
                    y: PreciseDecimal::from_int(0),
                },
                "50".to_string()
            ),
            PlanePoint {
                plane_type: Plane::POLAR,
                a: "1.2199999999993856733934483557".to_string(),
                b: "61.10999999998551537151064434".to_string()
            }
        );
        assert_eq!(
            rotate(
                PlanePoint {
                    plane_type: Plane::POLAR,
                    a: "4".to_string(),
                    b: "90".to_string()
                },
                CartesianPoint {
                    x: PreciseDecimal::from_int(4),
                    y: PreciseDecimal::from_int(4),
                },
                "90".to_string()
            ),
            PlanePoint {
                plane_type: Plane::POLAR,
                a: "3.999999999999999046149426467".to_string(),
                b: "359.99999999999999999999999999".to_string()
            }
        );
    }

    #[test]
    fn cartesian_rotate() {
        assert_eq!(
            rotate(
                PlanePoint {
                    plane_type: Plane::CARTESIAN,
                    a: "4".to_string(),
                    b: "4".to_string(),
                },
                CartesianPoint {
                    x: PreciseDecimal::from_int(8),
                    y: PreciseDecimal::from_int(0),
                },
                "90".to_string()
            ),
            PlanePoint {
                plane_type: Plane::CARTESIAN,
                a: "4.0000000000391914755241257792".to_string(),
                b: "-3.9999999993515959027994326119".to_string(),
            }
        );
    }
}
