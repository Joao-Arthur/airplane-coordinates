import { useState } from 'react';
import { Button } from '../../components/Button';
import { Input } from '../../components/Input';
import { useAirplanes } from '../../integrations/airplane/useAirplanes';

export function InRouteOfCollision() {
    const { getInRouteOfCollision } = useAirplanes();
    const [maxTime, setMaxTime] = useState(0);

    function onClick() {
        getInRouteOfCollision({ maxTime });
    }

    return (
        <>
            <Input title='Tempo mínimo' name='maxTime' value={maxTime} onChange={setMaxTime} />
            <Button title='Aviões em rota de colisão' onClick={onClick} />
        </>
    );
}
