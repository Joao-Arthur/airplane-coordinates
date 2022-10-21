use serde::Deserialize;
use serde_wasm_bindgen;
use wasm_bindgen::{prelude::wasm_bindgen, JsValue};

use crate::core::cartesian_plane::cartesian_point::CartesianPoint;
use crate::core::cartesian_plane::scalonate::scalonate as core_scalonate;

use super::cartesian_point_api::CartesianPointAPI;

#[derive(Deserialize)]
struct ScalonateArguments {
    point: CartesianPointAPI,
    factor: CartesianPointAPI,
}

#[wasm_bindgen]
pub fn scalonate(val: JsValue) -> Result<JsValue, JsValue> {
    let args: ScalonateArguments = serde_wasm_bindgen::from_value(val)?;

    let return_value = core_scalonate(
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
