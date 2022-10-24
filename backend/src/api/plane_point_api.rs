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
                x: PreciseDecimal::from_string(self.a),
                y: PreciseDecimal::from_string(self.b),
            },
            Planes::POLAR => polar_to_cartesian(PolarPoint {
                r: PreciseDecimal::from_string(self.a),
                a: PreciseDecimal::from_string(self.b),
            }),
        }
    }
}
