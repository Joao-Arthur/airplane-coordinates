use serde::Deserialize;

use crate::core::plane::cartesian::cartesian_point::CartesianPoint;
use crate::core::precise_decimal::PreciseDecimal;

#[derive(PartialEq, Debug, Deserialize)]
pub struct CartesianPointAPI {
    pub x: String,
    pub y: String,
}

impl CartesianPointAPI {
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
    fn to_point() {
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
