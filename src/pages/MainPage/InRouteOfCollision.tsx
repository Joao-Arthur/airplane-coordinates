import { useState } from 'react';
import { Button } from '../../components/Button';
import { Input } from '../../components/Input';

type props = {
    getInRouteOfCollision: (maxTime: number) => void;
}

export function InRouteOfCollision({ getInRouteOfCollision }: props) {
    const [maxTime, setMaxTime] = useState(0);

    function onClick() {

    }

    return (
        <>
            <Input title='Tempo mínimo' name='maxTime' value={maxTime} onChange={setMaxTime} />
            <Button title='Aviões em rota de colisão' onClick={onClick} />
        </>
    );
}