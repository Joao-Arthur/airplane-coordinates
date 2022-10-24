use serde::{Deserialize, Serialize};

use crate::core::cartesian_plane::cartesian_point::CartesianPoint;
use crate::core::plane_conversions::polar_to_cartesian::polar_to_cartesian;
use crate::core::polar_plane::polar_point::PolarPoint;
use crate::core::precise_decimal::PreciseDecimal;

use super::planes::Planes;

#[derive(Serialize, Deserialize)]
pub struct PlanePointAPI {
    pub plane: Planes,
    pub a: String,
    pub b: String,
}

impl PlanePointAPI {
    pub fn to_point(&self) -> CartesianPoint {
        match self.plane {
            Planes::CARTESIAN => CartesianPoint {
                x: PreciseDecimal::from_string(self.a.clone()),
                y: PreciseDecimal::from_string(self.b.clone()),
            },
            Planes::POLAR => polar_to_cartesian(PolarPoint {
                r: PreciseDecimal::from_string(self.a.clone()),
                a: PreciseDecimal::from_string(self.b.clone()),
            }),
        }
    }
}

#[cfg(test)]
mod test_plane_point_api {
    use crate::core::cartesian_plane::cartesian_point::CartesianPoint;
    use crate::core::precise_decimal::PreciseDecimal;

    use super::*;

    #[test]
    fn transform_to() {
        assert_eq!(
            PlanePointAPI {
                plane: Planes::CARTESIAN,
                a: "4.2948".to_string(),
                b: "-1.6825".to_string(),
            }
            .to_point(),
            CartesianPoint {
                x: PreciseDecimal::from_str("4.2948"),
                y: PreciseDecimal::from_str("-1.6825")
            },
        );
        assert_eq!(
            PlanePointAPI {
                plane: Planes::POLAR,
                a: "3".to_string(),
                b: "270".to_string(),
            }
            .to_point(),
            CartesianPoint {
                x: PreciseDecimal::from_str("0.0000000000000000000000000003"),
                y: PreciseDecimal::from_str("-3")
            },
        );
    }
}
