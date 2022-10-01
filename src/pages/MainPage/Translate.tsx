import { useState } from 'react';
import { Button } from '../../components/Button';
import { Form } from '../../components/Form';
import { Input } from '../../components/Input';
import { useAirplaneStore } from '../../integrations/airplane/airplanesStore';
import { useAirplanes } from '../../integrations/airplane/useAirplanes';

export function Translate() {
    const { translateCoordinates } = useAirplanes();
    const selectedIds = useAirplaneStore(state => state.selectedAirplanes);
    const [x, setX] = useState(0);
    const [y, setY] = useState(0);

    function onClick() {
        translateCoordinates({ selectedIds, x, y });
    }

    return (
        <Form name='Transladar'>
            <Input title='X' name='x' value={x} onChange={setX} />
            <Input title='Y' name='y' value={y} onChange={setY} />
            <Button title='Executar' onClick={onClick} />
        </Form>
    );
}
