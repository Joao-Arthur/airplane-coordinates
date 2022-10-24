use serde::Deserialize;
use serde_wasm_bindgen;
use wasm_bindgen::{prelude::wasm_bindgen, JsValue};

use crate::features::scalonate::scalonate as feature_scalonate;

use super::cartesian_point_api::CartesianPointAPI;
use super::plane_point_api::PlanePointAPI;

#[derive(Deserialize)]
struct ScalonateArguments {
    point: PlanePointAPI,
    factor: CartesianPointAPI,
}

#[allow(dead_code)]
#[wasm_bindgen]
pub fn scalonate(val: JsValue) -> Result<JsValue, JsValue> {
    let args: ScalonateArguments = serde_wasm_bindgen::from_value(val)?;
    let point = args.point.to_point();
    let factor = args.factor.to_point();
    let result = feature_scalonate(point, factor);
    let serializable = PlanePointAPI::from_point(result);

    Ok(serde_wasm_bindgen::to_value(&serializable)?)
}
