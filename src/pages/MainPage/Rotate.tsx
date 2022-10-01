import { useState } from 'react';
import { Button } from '../../components/Button';
import { Form } from '../../components/Form';
import { Input } from '../../components/Input';
import { useAirplaneStore } from '../../integrations/airplane/airplanesStore';
import { useAirplanes } from '../../integrations/airplane/useAirplanes';

export function Rotate() {
    const { rotateCoordinates } = useAirplanes();
    const selectedIds = useAirplaneStore(state => state.selectedAirplanes);
    const [angle, setAngle] = useState(0);
    const [centerOfRotationX, setCenterOfRotationX] = useState(0);
    const [centerOfRotationY, setCenterOfRotationY] = useState(0);

    function onClick() {
        rotateCoordinates({ selectedIds, angle, centerOfRotationX, centerOfRotationY });
    }

    return (
        <Form name='Rotacionar'>
            <Input title='Ângulo' name='angle' value={angle} onChange={setAngle} />
            <Input title='centro de rotação X' name='centerOfRotationX' value={centerOfRotationX} onChange={setCenterOfRotationX} />
            <Input title='centro de rotação Y' name='centerOfRotationY' value={centerOfRotationY} onChange={setCenterOfRotationY} />
            <Button title='Executar' onClick={onClick} />
        </Form>
    );
}
