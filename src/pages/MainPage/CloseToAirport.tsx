import { useState } from 'react';
import { Button } from '../../components/Button';
import { Form } from '../../components/Form';
import { Input } from '../../components/Input';
import { useAirplanes } from '../../integrations/airplane/useAirplanes';

export function CloseToAirport() {
    const { getCloseToAirport } = useAirplanes();
    const [maxDistance, setMaxDistance] = useState(0);

    function onClick() {
        getCloseToAirport({ maxDistance });
    }

    return (
        <Form name='Aviões próximos ao aeroporto'>
            <Input title='Distancia mínima' name='maxDistance' value={maxDistance} onChange={setMaxDistance} />
            <Button title='Calcular' onClick={onClick} />
        </Form>
    );
}
