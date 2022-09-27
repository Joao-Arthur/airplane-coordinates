import { useState } from 'react';
import { Button } from '../../components/Button';
import { Input } from '../../components/Input';

type props = {
    selectedIds: readonly string[];
    rotateCoordinates: (
        selectedIds: readonly string[],
        angle: number,
        centerOfRotationX: number,
        centerOfRotationY: number
    ) => void;
}

export function Rotate({ selectedIds, rotateCoordinates }: props) {
    const [angle, setAngle] = useState(0);
    const [centerOfRotationX, setCenterOfRotationX] = useState(0);
    const [centerOfRotationY, setCenterOfRotationY] = useState(0);

    function onClick() {
        rotateCoordinates(selectedIds, angle, centerOfRotationX, centerOfRotationY);
    }

    return (
        <>
            <Input title='Ângulo' name='angle' value={angle} onChange={setAngle} />
            <Input title='centro de rotação X' name='centerOfRotationX' value={centerOfRotationX} onChange={setCenterOfRotationX} />
            <Input title='centro de rotação Y' name='centerOfRotationY' value={centerOfRotationY} onChange={setCenterOfRotationY} />
            <Button title='Rotacionar' onClick={onClick} />
        </>
    );
}