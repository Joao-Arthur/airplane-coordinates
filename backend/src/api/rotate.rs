use serde::Deserialize;
use serde_wasm_bindgen;
use wasm_bindgen::{prelude::wasm_bindgen, JsValue};

use crate::core::polar_plane::polar_point::PolarPoint;
use crate::core::polar_plane::rotate::rotate as core_rotate;
use crate::core::precise_decimal::PreciseDecimal;

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
        PolarPoint {
            r: PreciseDecimal::from_string(args.point.x),
            a: PreciseDecimal::from_string(args.point.y),
        },
        args.angle.as_str(),
    );

    let serializable = CartesianPointAPI {
        x: return_value.r.value,
        y: return_value.a.value,
    };

    Ok(serde_wasm_bindgen::to_value(&serializable)?)
}
