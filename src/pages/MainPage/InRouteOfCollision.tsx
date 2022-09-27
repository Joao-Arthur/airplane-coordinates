import { useState } from 'react';
import { Button } from '../../components/Button';
import { Input } from '../../components/Input';
import { gatewayAirplanesInRouteOfCollisionParamsType } from '../../features/airplane/gateways';

type props = {
    getInRouteOfCollision: (airplanesInRouteOfCollisionParams: gatewayAirplanesInRouteOfCollisionParamsType) => void;
}

export function InRouteOfCollision({ getInRouteOfCollision }: props) {
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