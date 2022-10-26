use serde::Deserialize;
use serde_wasm_bindgen;
use wasm_bindgen::{prelude::wasm_bindgen, JsValue};

use crate::features::translate::translate as feature_translate;

use super::cartesian_point_api::CartesianPointAPI;
use super::plane_point_api::PlanePointAPI;

#[derive(Deserialize)]
struct TranslateArguments {
    points: Vec<PlanePointAPI>,
    desired_point: CartesianPointAPI,
    max_distance: String,
}

#[allow(dead_code)]
#[wasm_bindgen]
pub fn points_close_to_each_other() {}
