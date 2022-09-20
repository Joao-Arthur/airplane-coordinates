import { Button } from "../../components/Button";
import { Input } from "../../components/Input";

export function InRouteOfCollision() {
    return (
        <>
            <Input title='Tempo mínimo' name='minDistance' />
            <Button title='Aviões em rota de colisão' onClick={() => { }} />
        </>
    );
}