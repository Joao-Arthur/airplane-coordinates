use serde::{Deserialize, Serialize};

use crate::core::plane::plane_point::PlanePoint;
use crate::core::precise_decimal::PreciseDecimal;

use super::plane_api::PlaneAPI;

#[derive(Serialize, Deserialize)]
pub struct PlanePointAPI {
    pub plane_type: PlaneAPI,
    pub a: String,
    pub b: String,
}

impl PlanePointAPI {
    pub fn from_point(point: PlanePoint) -> PlanePointAPI {
        PlanePointAPI {
            plane_type: PlaneAPI::from_plane(point.plane_type),
            a: point.a.value,
            b: point.b.value,
        }
    }

    pub fn to_point(&self) -> PlanePoint {
        PlanePoint {
            plane_type: self.plane_type.to_plane(),
            a: PreciseDecimal::from_string(self.a.clone()),
            b: PreciseDecimal::from_string(self.b.clone()),
        }
    }
}

#[cfg(test)]
mod test_plane_point_api {
    use crate::core::plane::plane::Plane;
    use crate::core::precise_decimal::PreciseDecimal;

    use super::*;

    #[test]
    fn to_point() {
        assert_eq!(
            PlanePointAPI {
                plane_type: PlaneAPI::CARTESIAN,
                a: "4.2948".to_string(),
                b: "-1.6825".to_string(),
            }
            .to_point(),
            PlanePoint {
                plane_type: Plane::CARTESIAN,
                a: PreciseDecimal::from_str("4.2948"),
                b: PreciseDecimal::from_str("-1.6825"),
            },
        );
    }
}
