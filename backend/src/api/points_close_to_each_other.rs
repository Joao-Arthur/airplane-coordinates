use serde::Deserialize;
use serde_wasm_bindgen;
use wasm_bindgen::{prelude::wasm_bindgen, JsValue};

use super::cartesian_point_api::CartesianPointAPI;
use super::plane_point_api::PlanePointAPI;

#[derive(Deserialize)]
struct TranslateArguments {
    points: Vec<PlanePointAPI>,
    max_distance: String,
}

#[allow(dead_code)]
#[wasm_bindgen]
pub fn points_close_to_each_other() {
    let args: ScalonateArguments = serde_wasm_bindgen::from_value(val)?;

    Ok(serde_wasm_bindgen::to_value(&serializable)?)
}
