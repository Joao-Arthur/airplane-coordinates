import { useState } from 'react';
import { Button } from '../../components/Button';
import { Input } from '../../components/Input';
import { gatewayRotateAirplaneCoordinatesParamsType } from '../../features/airplane/gateways';
import { useAirplaneStore } from './airplanesStore';

type props = {
    readonly rotateCoordinates: (rotateAirplaneCoordinatesParams: gatewayRotateAirplaneCoordinatesParamsType) => void;
}

export function Rotate({ rotateCoordinates }: props) {
    const selectedIds = useAirplaneStore(state => state.selectedAirplanes);
    const [angle, setAngle] = useState(0);
    const [centerOfRotationX, setCenterOfRotationX] = useState(0);
    const [centerOfRotationY, setCenterOfRotationY] = useState(0);

    function onClick() {
        rotateCoordinates({ selectedIds, angle, centerOfRotationX, centerOfRotationY });
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