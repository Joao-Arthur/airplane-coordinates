use crate::core::precise_decimal::PreciseDecimal;

#[derive(PartialEq, Debug)]
pub struct PolarPoint {
    pub r: PreciseDecimal,
    pub a: PreciseDecimal,
}
