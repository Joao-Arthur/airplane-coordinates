use serde::{Deserialize, Serialize};

use crate::core::plane::cartesian::cartesian_point::CartesianPoint;
use crate::core::precise_decimal::PreciseDecimal;

#[derive(Debug, Serialize, Deserialize)]
pub struct CartesianPointAPI {
    pub x: String,
    pub y: String,
}

impl PartialEq for CartesianPointAPI {
    fn eq(&self, other: &Self) -> bool {
        self.x == other.x && self.y == self.y
    }
}

impl CartesianPointAPI {
    pub fn from_point(point: CartesianPoint) -> CartesianPointAPI {
        CartesianPointAPI {
            x: point.x.value,
            y: point.y.value,
        }
    }

    pub fn to_point(&self) -> CartesianPoint {
        CartesianPoint {
            x: PreciseDecimal::from_string(self.x.clone()),
            y: PreciseDecimal::from_string(self.y.clone()),
        }
    }
}

#[cfg(test)]
mod test_cartesian_point_api {
    use crate::core::plane::cartesian::cartesian_point::CartesianPoint;
    use crate::core::precise_decimal::PreciseDecimal;

    use super::*;

    #[test]
    fn get_from() {
        assert_eq!(
            CartesianPointAPI::from_point(CartesianPoint {
                x: PreciseDecimal::from_str("4.2948"),
                y: PreciseDecimal::from_str("-1.6825")
            }),
            CartesianPointAPI {
                x: "4.2948".to_string(),
                y: "-1.6825".to_string(),
            }
        );
    }

    #[test]
    fn transform_to() {
        assert_eq!(
            CartesianPointAPI {
                x: "4.2948".to_string(),
                y: "-1.6825".to_string(),
            }
            .to_point(),
            CartesianPoint {
                x: PreciseDecimal::from_str("4.2948"),
                y: PreciseDecimal::from_str("-1.6825")
            },
        )
    }
}
