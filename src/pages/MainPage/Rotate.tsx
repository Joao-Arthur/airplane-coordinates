import { Button } from "../../components/Button";
import { Input } from "../../components/Input";

type props = {
    rotateCoordinates: (
        selectedIds: readonly string[],
        angle: number,
        centerOfRotationX: number,
        centerOfRotationY: number
    ) => void;
}

export function Rotate({ rotateCoordinates }: props) {
    return (
        <>
            <Input title='X' name='x' />
            <Input title='Y' name='y' />
            <Button title='Rotacionar' onClick={() => { }} />
        </>
    );
}