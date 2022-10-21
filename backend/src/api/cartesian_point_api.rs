use serde::{Deserialize, Serialize};

#[derive(Serialize, Deserialize)]
pub struct CartesianPointAPI {
    pub x: String,
    pub y: String,
}
