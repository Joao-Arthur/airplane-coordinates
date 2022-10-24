use serde::Deserialize;
use serde_wasm_bindgen;
use wasm_bindgen::{prelude::wasm_bindgen, JsValue};

use crate::core::precise_decimal::PreciseDecimal;
use crate::features::rotate::rotate as feature_rotate;

use super::cartesian_point_api::CartesianPointAPI;
use super::plane_point_api::PlanePointAPI;

#[derive(Deserialize)]
struct RotateArguments {
    point: PlanePointAPI,
    center_of_rotation: CartesianPointAPI,
    angle: String,
}

#[allow(dead_code)]
#[wasm_bindgen]
pub fn rotate(val: JsValue) -> Result<JsValue, JsValue> {
    let args: RotateArguments = serde_wasm_bindgen::from_value(val)?;
    let point = args.point.to_point();
    let center_of_rotation = args.center_of_rotation.to_point();
    let angle = PreciseDecimal::from_string(args.angle);
    let rotated_point = feature_rotate(point, center_of_rotation, angle);
    let serializable = PlanePointAPI::from_point(rotated_point);
    Ok(serde_wasm_bindgen::to_value(&serializable)?)
}
