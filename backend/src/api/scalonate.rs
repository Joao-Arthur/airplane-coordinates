use serde::Deserialize;
use serde_wasm_bindgen;
use wasm_bindgen::{prelude::wasm_bindgen, JsValue};

use crate::core::cartesian_plane::cartesian_point::CartesianPoint;
use crate::core::cartesian_plane::scalonate::scalonate as core_scalonate;
use crate::core::precise_decimal::PreciseDecimal;

use super::cartesian_point_api::CartesianPointAPI;

#[derive(Deserialize)]
struct ScalonateArguments {
    point: CartesianPointAPI,
    factor: CartesianPointAPI,
}

#[allow(dead_code)]
#[wasm_bindgen]
pub fn scalonate(val: JsValue) -> Result<JsValue, JsValue> {
    let args: ScalonateArguments = serde_wasm_bindgen::from_value(val)?;

    let return_value = core_scalonate(
        CartesianPoint {
            x: PreciseDecimal::from_string(args.point.x),
            y: PreciseDecimal::from_string(args.point.y),
        },
        CartesianPoint {
            x: PreciseDecimal::from_string(args.factor.x),
            y: PreciseDecimal::from_string(args.factor.y),
        },
    );
    let serializable = CartesianPointAPI {
        x: return_value.x.value,
        y: return_value.y.value,
    };

    Ok(serde_wasm_bindgen::to_value(&serializable)?)
}
