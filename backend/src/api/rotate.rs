use serde::Deserialize;
use serde_wasm_bindgen;
use wasm_bindgen::{prelude::wasm_bindgen, JsValue};

use crate::core::polar_plane::polar_point::NewPolarPoint;
use crate::core::polar_plane::rotate::rotate as core_rotate;

use super::cartesian_point_api::CartesianPointAPI;

#[derive(Deserialize)]
struct RotateArguments {
    point: CartesianPointAPI,
    center_of_rotation: CartesianPointAPI,
    angle: String,
}

#[allow(dead_code)]
#[wasm_bindgen]
pub fn rotate(val: JsValue) -> Result<JsValue, JsValue> {
    let args: RotateArguments = serde_wasm_bindgen::from_value(val)?;

    let return_value = core_rotate(
        NewPolarPoint {
            r: args.point.x,
            a: args.point.y,
        },
        args.angle.as_str(),
    );

    let serializable = CartesianPointAPI {
        x: return_value.r.to_string(),
        y: return_value.a.to_string(),
    };

    Ok(serde_wasm_bindgen::to_value(&serializable)?)
}
