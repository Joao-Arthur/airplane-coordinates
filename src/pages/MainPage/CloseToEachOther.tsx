import { useState } from 'react';
import { Button } from '../../components/Button';
import { Form } from '../../components/Form';
import { Input } from '../../components/Input';
import { useAirplanes } from '../../integrations/airplane/useAirplanes';

export function CloseToEachOther() {
    const { getCloseToEachOther } = useAirplanes();
    const [maxDistance, setMaxDistance] = useState(0);

    function onClick() {
        getCloseToEachOther({ maxDistance });
    }

    return (
        <Form name='Aviões próximos entre si'>
            <Input title='Distancia mínima' name='maxDistance' value={maxDistance} onChange={setMaxDistance} />
            <Button title='Calcular' onClick={onClick} />
        </Form>
    );
}
