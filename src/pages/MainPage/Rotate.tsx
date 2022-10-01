import { useState } from 'react';
import { Button } from '../../components/Button';
import { Form } from '../../components/Form';
import { Group } from '../../components/Group';
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
            <Group>
                <Input title='Ângulo' name='angle' value={angle} onChange={setAngle} />
                <Input title='X' name='centerOfRotationX' value={centerOfRotationX} onChange={setCenterOfRotationX} />
                <Input title='Y' name='centerOfRotationY' value={centerOfRotationY} onChange={setCenterOfRotationY} />
            </Group>
            <Button title='Executar' onClick={onClick} />
        </Form>
    );
}
