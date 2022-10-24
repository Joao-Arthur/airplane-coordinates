use serde::{Deserialize, Serialize};

use crate::core::plane::plane::Plane;

#[derive(Serialize, Deserialize)]
pub enum PlaneAPI {
    CARTESIAN,
    POLAR,
}

impl PlaneAPI {
    pub fn from_plane(plane: Plane) -> PlaneAPI {
        match plane {
            Plane::CARTESIAN => PlaneAPI::CARTESIAN,
            Plane::POLAR => PlaneAPI::POLAR,
        }
    }

    pub fn to_plane(&self) -> Plane {
        match self {
            PlaneAPI::CARTESIAN => Plane::CARTESIAN,
            PlaneAPI::POLAR => Plane::POLAR,
        }
    }
}
