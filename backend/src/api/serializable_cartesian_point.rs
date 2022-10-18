use serde::{Deserialize, Serialize};

#[derive(Serialize, Deserialize)]
pub struct SerializableCartesianPoint {
    pub x: String,
    pub y: String,
}
