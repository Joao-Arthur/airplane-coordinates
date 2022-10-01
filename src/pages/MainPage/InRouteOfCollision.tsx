import { useState } from 'react';
import { Button } from '../../components/Button';
import { Form } from '../../components/Form';
import { Input } from '../../components/Input';
import { useAirplanes } from '../../integrations/airplane/useAirplanes';

export function InRouteOfCollision() {
    const { getInRouteOfCollision } = useAirplanes();
    const [maxTime, setMaxTime] = useState(0);

    function onClick() {
        getInRouteOfCollision({ maxTime });
    }

    return (
        <Form name='Aviões em rota de colisão'>
            <Input title='Tempo mínimo' name='maxTime' value={maxTime} onChange={setMaxTime} />
            <Button title='Calcular' onClick={onClick} />
        </Form>
    );
}
