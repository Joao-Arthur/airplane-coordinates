import { Button } from "../../components/Button";
import { Input } from "../../components/Input";

type props = {
    getInRouteOfCollision: (maxTime: number) => void;
}

export function InRouteOfCollision({ getInRouteOfCollision }: props) {
    return (
        <>
            <Input title='Tempo mínimo' name='minDistance' />
            <Button title='Aviões em rota de colisão' onClick={() => { }} />
        </>
    );
}