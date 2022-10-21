use serde::{Deserialize, Serialize};

#[derive(Serialize, Deserialize)]
pub enum Planes {
    CARTESIAN,
    POLAR,
}
