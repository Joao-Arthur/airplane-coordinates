import { useState } from 'react';
import { Button } from '../../components/Button';
import { Input } from '../../components/Input';
import { gatewayAirplanesCloseToEachOtherParamsType } from '../../features/airplane/gateways';

type props = {
    readonly getCloseToEachOther: (airplanesCloseToEachOtherParams: gatewayAirplanesCloseToEachOtherParamsType) => void;
}

export function CloseToEachOther({ getCloseToEachOther }: props) {
    const [maxDistance, setMaxDistance] = useState(0);

    function onClick() {
        getCloseToEachOther({ maxDistance });
    }

    return (
        <>
            <Input title='Distancia mínima' name='maxDistance' value={maxDistance} onChange={setMaxDistance} />
            <Button title='Aviões próximos entre si' onClick={onClick} />
        </>
    );
}