use super::planes::Planes;
use serde::{Deserialize, Serialize};

#[derive(Serialize, Deserialize)]
pub struct AirplanePoint {
    pub plane: Planes,
    pub a: String,
    pub b: String,
}
