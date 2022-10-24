use serde::Deserialize;
use serde_wasm_bindgen;
use wasm_bindgen::{prelude::wasm_bindgen, JsValue};

use super::cartesian_point_api::CartesianPointAPI;
use super::plane_point_api::PlanePointAPI;

#[derive(Deserialize)]
struct TranslateArguments {
    point: PlanePointAPI,
    factor: CartesianPointAPI,
}

#[allow(dead_code)]
#[wasm_bindgen]
pub fn translate(val: JsValue) -> Result<JsValue, JsValue> {
    let args: TranslateArguments = serde_wasm_bindgen::from_value(val)?;
    let point = args.point.to_point();
    let factor = args.factor.to_point();
    let translated_value = point + factor;
    let serializable = CartesianPointAPI::from_point(translated_value);

    Ok(serde_wasm_bindgen::to_value(&serializable)?)
}
