use serde::{Deserialize, Serialize};

use crate::core::cartesian_plane::cartesian_point::CartesianPoint;
use crate::core::precise_decimal::PreciseDecimal;

#[derive(Serialize, Deserialize)]
pub struct CartesianPointAPI {
    pub x: String,
    pub y: String,
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
            x: PreciseDecimal::from_string(self.x),
            y: PreciseDecimal::from_string(self.y),
        }
    }
}
