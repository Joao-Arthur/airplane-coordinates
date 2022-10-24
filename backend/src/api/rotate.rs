use serde::Deserialize;
use serde_wasm_bindgen;
use wasm_bindgen::{prelude::wasm_bindgen, JsValue};

use crate::core::plane_conversions::cartesian_to_polar::cartesian_to_polar;
use crate::core::plane_conversions::polar_to_cartesian::polar_to_cartesian;
use crate::core::polar_plane::rotate::rotate as core_rotate;

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
    let offset_point = point - center_of_rotation.clone();
    let point_as_polar = cartesian_to_polar(offset_point);
    let rotated_point = core_rotate(point_as_polar, args.angle.as_str());
    let point_as_cartesian = polar_to_cartesian(rotated_point);
    let unoffseted_point = point_as_cartesian + center_of_rotation;
    let serializable = CartesianPointAPI::from_point(unoffseted_point);

    Ok(serde_wasm_bindgen::to_value(&serializable)?)
}
