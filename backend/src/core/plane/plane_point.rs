use crate::core::precise_decimal::PreciseDecimal;

use super::cartesian::cartesian_point::CartesianPoint;
use super::conversions::cartesian_to_polar::cartesian_to_polar;
use super::conversions::polar_to_cartesian::polar_to_cartesian;
use super::plane::Plane;
use super::polar::polar_point::PolarPoint;

#[derive(Debug, PartialEq)]
pub struct PlanePoint {
    pub plane_type: Plane,
    pub a: PreciseDecimal,
    pub b: PreciseDecimal,
}

impl PlanePoint {
    pub fn to_cartesian(&self) -> CartesianPoint {
        match self.plane_type {
            Plane::CARTESIAN => CartesianPoint {
                x: self.a.clone(),
                y: self.b.clone(),
            },
            Plane::POLAR => polar_to_cartesian(PolarPoint {
                r: self.a.clone(),
                a: self.b.clone(),
            }),
        }
    }

    pub fn to_polar(&self) -> PolarPoint {
        match self.plane_type {
            Plane::CARTESIAN => cartesian_to_polar(CartesianPoint {
                x: self.a.clone(),
                y: self.b.clone(),
            }),
            Plane::POLAR => PolarPoint {
                r: self.a.clone(),
                a: self.b.clone(),
            },
        }
    }

    pub fn from_cartesian(point: CartesianPoint) -> PlanePoint {
        PlanePoint {
            plane_type: Plane::CARTESIAN,
            a: point.x.clone(),
            b: point.y.clone(),
        }
    }

    pub fn from_polar(point: PolarPoint) -> PlanePoint {
        PlanePoint {
            plane_type: Plane::POLAR,
            a: point.r.clone(),
            b: point.a.clone(),
        }
    }
}

#[cfg(test)]
mod test_plane_point {
    use crate::core::plane::cartesian::cartesian_point::CartesianPoint;
    use crate::core::precise_decimal::PreciseDecimal;

    use super::*;

    #[test]
    fn to_cartesian() {
        assert_eq!(
            PlanePoint {
                plane_type: Plane::CARTESIAN,
                a: PreciseDecimal::from_str("4.2948"),
                b: PreciseDecimal::from_str("-1.6825"),
            }
            .to_cartesian(),
            CartesianPoint {
                x: PreciseDecimal::from_str("4.2948"),
                y: PreciseDecimal::from_str("-1.6825")
            },
        );
        assert_eq!(
            PlanePoint {
                plane_type: Plane::POLAR,
                a: PreciseDecimal::from_int(3),
                b: PreciseDecimal::from_int(270),
            }
            .to_cartesian(),
            CartesianPoint {
                x: PreciseDecimal::from_str("0.0000000000000000000000000003"),
                y: PreciseDecimal::from_str("-3")
            },
        );
    }

    #[test]
    fn to_polar() {
        assert_eq!(
            PlanePoint {
                plane_type: Plane::CARTESIAN,
                a: PreciseDecimal::from_str("4.2948"),
                b: PreciseDecimal::from_str("-1.6825"),
            }
            .to_polar(),
            PolarPoint {
                r: PreciseDecimal::from_str("4.612603743006762986208671845"),
                a: PreciseDecimal::from_str("338.6070977245781950563836765")
            },
        );
        assert_eq!(
            PlanePoint {
                plane_type: Plane::POLAR,
                a: PreciseDecimal::from_int(3),
                b: PreciseDecimal::from_int(270),
            }
            .to_polar(),
            PolarPoint {
                r: PreciseDecimal::from_int(3),
                a: PreciseDecimal::from_int(270)
            },
        );
    }

    #[test]
    fn from_cartesian() {
        assert_eq!(
            PlanePoint::from_cartesian(CartesianPoint {
                x: PreciseDecimal::from_str("4.2948"),
                y: PreciseDecimal::from_str("-1.6825")
            }),
            PlanePoint {
                plane_type: Plane::CARTESIAN,
                a: PreciseDecimal::from_str("4.2948"),
                b: PreciseDecimal::from_str("-1.6825"),
            }
        );
    }

    #[test]
    fn from_polar() {
        assert_eq!(
            PlanePoint::from_polar(PolarPoint {
                r: PreciseDecimal::from_str("4.612603743006762986208671845"),
                a: PreciseDecimal::from_str("359.99348334930711180245669530")
            }),
            PlanePoint {
                plane_type: Plane::POLAR,
                a: PreciseDecimal::from_str("4.612603743006762986208671845"),
                b: PreciseDecimal::from_str("359.99348334930711180245669530")
            }
        );
    }
}
