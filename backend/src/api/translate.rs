use serde::Deserialize;
use serde_wasm_bindgen;
use wasm_bindgen::{prelude::wasm_bindgen, JsValue};

use crate::core::cartesian_plane::cartesian_point::CartesianPoint;
use crate::core::cartesian_plane::translate::translate as core_translate;
use crate::core::precise_decimal::PreciseDecimal;

use super::cartesian_point_api::CartesianPointAPI;

#[derive(Deserialize)]
struct TranslateArguments {
    point: CartesianPointAPI,
    factor: CartesianPointAPI,
}

#[allow(dead_code)]
#[wasm_bindgen]
pub fn translate(val: JsValue) -> Result<JsValue, JsValue> {
    let args: TranslateArguments = serde_wasm_bindgen::from_value(val)?;

    let return_value = core_translate(
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
