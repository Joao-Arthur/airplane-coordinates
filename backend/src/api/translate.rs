use serde::Deserialize;
use serde_wasm_bindgen;
use wasm_bindgen::{prelude::wasm_bindgen, JsValue};

use crate::core::cartesian_plane::cartesian_point::CartesianPoint;
use crate::core::cartesian_plane::translate::translate as core_translate;

use super::cartesian_point_api::CartesianPointAPI;

#[derive(Deserialize)]
struct TranslateArguments {
    point: CartesianPointAPI,
    factor: CartesianPointAPI,
}

#[wasm_bindgen]
pub fn translate(val: JsValue) -> Result<JsValue, JsValue> {
    let args: TranslateArguments = serde_wasm_bindgen::from_value(val)?;

    let return_value = core_translate(
        CartesianPoint {
            x: args.point.x.parse().unwrap(),
            y: args.point.y.parse().unwrap(),
        },
        CartesianPoint {
            x: args.factor.x.parse().unwrap(),
            y: args.factor.y.parse().unwrap(),
        },
    );

    let serializable = CartesianPointAPI {
        x: return_value.x.to_string(),
        y: return_value.y.to_string(),
    };

    Ok(serde_wasm_bindgen::to_value(&serializable)?)
}
