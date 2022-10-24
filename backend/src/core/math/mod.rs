pub trait MathOperations<T> {
    fn sqrt(&self) -> T;
    fn square(&self) -> T;
    fn cos(&self) -> T;
    fn sin(&self) -> T;
    fn atan(&self, other: T) -> T;
}
