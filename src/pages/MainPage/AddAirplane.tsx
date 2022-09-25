import { Button } from "../../components/Button";
import { Input } from "../../components/Input";

type props = {
    add: (airplaneParams: { x: number; y: number; radius: number; angle: number; speed: number; direction: number; }) => void;
}

export function AddAirplane({ add }: props) {
    return (
        <>
            <Input title='X' name='x' />
            <Input title='Y' name='y' />
            <Input title='Raio' name='raio' />
            <Input title='Ângulo' name='angulo' />
            <Input title='Velocidade' name='velocidade' />
            <Input title='Direção' name='direcao' />
            <Button title='Adicionar' onClick={() => { }} />
        </>
    );
}