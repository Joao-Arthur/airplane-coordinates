use rust_decimal::prelude::*;

use crate::core::math::MathOperations;
use crate::core::trigonometry::consts::*;

use super::PreciseDecimal;

impl MathOperations<PreciseDecimal> for PreciseDecimal {
    fn sqrt(&self) -> PreciseDecimal {
        let decimal = Decimal::from_str(self.value.as_str()).unwrap();

        PreciseDecimal::from_string(decimal.sqrt().unwrap().to_string())
    }

    fn square(&self) -> PreciseDecimal {
        let decimal = Decimal::from_str(self.value.as_str()).unwrap();

        PreciseDecimal::from_string(decimal.powi(2).to_string())
    }

    fn cos(&self) -> PreciseDecimal {
        match self.value.as_str() {
            AS_RAD_45 => PreciseDecimal::from_str("0.7071067811865475244008443621"),
            AS_RAD_135 => PreciseDecimal::from_str("-0.7071067811865475244008443621"),
            AS_RAD_225 => PreciseDecimal::from_str("-0.7071067811865475244008443621"),
            AS_RAD_315 => PreciseDecimal::from_str("0.7071067811865475244008443621"),
            _ => {
                let decimal = Decimal::from_str(self.value.as_str()).unwrap();

                PreciseDecimal::from_string(decimal.cos().to_string())
            }
        }
    }

    fn sin(&self) -> PreciseDecimal {
        match self.value.as_str() {
            AS_RAD_45 => PreciseDecimal::from_str("0.7071067811865475244008443621"),
            AS_RAD_135 => PreciseDecimal::from_str("0.7071067811865475244008443621"),
            AS_RAD_225 => PreciseDecimal::from_str("-0.7071067811865475244008443621"),
            AS_RAD_315 => PreciseDecimal::from_str("-0.7071067811865475244008443621"),
            _ => {
                let decimal = Decimal::from_str(self.value.as_str()).unwrap();
                PreciseDecimal::from_string(decimal.sin().to_string())
            }
        }
    }

    fn atan(&self, other: PreciseDecimal) -> PreciseDecimal {
        let self_decimal: f64 = self.value.parse::<f64>().unwrap();
        let other_decimal: f64 = other.value.parse::<f64>().unwrap();

        PreciseDecimal::from_string((self_decimal.atan2(other_decimal)).to_string())
    }
}

#[cfg(test)]
mod test_custom_operations {
    use super::*;

    #[test]
    fn sqrt() {
        assert_eq!(
            PreciseDecimal::from_str("1").sqrt(),
            PreciseDecimal::from_str("1.0000000000000000000000000000")
        );
        assert_eq!(
            PreciseDecimal::from_str("2").sqrt(),
            PreciseDecimal::from_str("1.4142135623730950488016887242")
        );
        assert_eq!(
            PreciseDecimal::from_str("3").sqrt(),
            PreciseDecimal::from_str("1.7320508075688772935274463415")
        );
        assert_eq!(
            PreciseDecimal::from_str("4").sqrt(),
            PreciseDecimal::from_str("2")
        );
        assert_eq!(
            PreciseDecimal::from_str("8").sqrt(),
            PreciseDecimal::from_str("2.8284271247461900976033774484")
        );
    }

    #[test]
    fn square() {
        assert_eq!(
            PreciseDecimal::from_str("1").square(),
            PreciseDecimal::from_str("1")
        );
        assert_eq!(
            PreciseDecimal::from_str("1.4142135623730950488016887242").square(),
            PreciseDecimal::from_str("2.0000000000000000000000000000")
        );
        assert_eq!(
            PreciseDecimal::from_str("1.7320508075688772935274463415").square(),
            PreciseDecimal::from_str("3.0000000000000000000000000000")
        );
        assert_eq!(
            PreciseDecimal::from_str("2").square(),
            PreciseDecimal::from_str("4")
        );
        assert_eq!(
            PreciseDecimal::from_str("2.8284271247461900976033774484").square(),
            PreciseDecimal::from_str("8.000000000000000000000000000")
        );
    }

    #[test]
    fn sin() {
        assert_eq!(
            PreciseDecimal::from_str("0").sin(),
            PreciseDecimal::from_str("0")
        );
        assert_eq!(
            PreciseDecimal::from_str("1").sin(),
            PreciseDecimal::from_str("0.8414709848054038642624295038")
        );
        assert_eq!(
            PreciseDecimal::from_str("2").sin(),
            PreciseDecimal::from_str("0.9092974268256001903062739251")
        );
        assert_eq!(
            PreciseDecimal::from_str("3").sin(),
            PreciseDecimal::from_str("0.1411200080598672220992683907")
        );
        assert_eq!(
            PreciseDecimal::from_str("4").sin(),
            PreciseDecimal::from_str("-0.7568024952723602702785983780")
        );
        assert_eq!(
            PreciseDecimal::from_str("5").sin(),
            PreciseDecimal::from_str("-0.9589242746631378003461760450")
        );
        assert_eq!(
            PreciseDecimal::from_str("6").sin(),
            PreciseDecimal::from_str("-0.2794154981989258607202506132")
        );
        assert_eq!(
            PreciseDecimal::from_str("7").sin(),
            PreciseDecimal::from_str("0.6569865987166758570704634881")
        );
    }

    #[test]
    fn cos() {
        assert_eq!(
            PreciseDecimal::from_str("0").cos(),
            PreciseDecimal::from_str("1")
        );
        assert_eq!(
            PreciseDecimal::from_str("1").cos(),
            PreciseDecimal::from_str("0.5403023058680302458227001515")
        );
        assert_eq!(
            PreciseDecimal::from_str("2").cos(),
            PreciseDecimal::from_str("-0.4161468365471396956896160433")
        );
        assert_eq!(
            PreciseDecimal::from_str("3").cos(),
            PreciseDecimal::from_str("-0.9899924966004454571360214443")
        );
        assert_eq!(
            PreciseDecimal::from_str("4").cos(),
            PreciseDecimal::from_str("-0.6536436208616620954476562566")
        );
        assert_eq!(
            PreciseDecimal::from_str("5").cos(),
            PreciseDecimal::from_str("0.2836621854632262496748600387")
        );
        assert_eq!(
            PreciseDecimal::from_str("6").cos(),
            PreciseDecimal::from_str("0.9601702866503654655107475412")
        );
        assert_eq!(
            PreciseDecimal::from_str("7").cos(),
            PreciseDecimal::from_str("0.7539022543049938919232610909")
        );
    }
}
