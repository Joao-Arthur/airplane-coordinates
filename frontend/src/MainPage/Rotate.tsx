import { useForm } from 'react-hook-form';
import { Button } from '../components/Button';
import { Form } from '../components/Form';
import { Group } from '../components/Group';
import { Input } from '../components/Input';
import { useAirplaneStore } from '../integrations/airplane/airplanesStore';
import { useAirplanes } from '../integrations/airplane/useAirplanes';

type fieldsType = {
    readonly angle: string;
    readonly x: string;
    readonly y: string;
}

export function Rotate() {
    const { register, handleSubmit } = useForm<fieldsType>({
        defaultValues: {
            angle: '0',
            x: '0',
            y: '0',
        },
    });
    const { rotateCoordinates } = useAirplanes();
    const selectedIds = useAirplaneStore(state => state.selectedAirplanes);

    function onHandleSubmit({ angle, x, y }: fieldsType) {
        rotateCoordinates({ selectedIds, centerOfRotation: { x, y }, angle });
    }

    return (
        <Form name='Rotacionar' onSubmit={handleSubmit(onHandleSubmit)}>
            <Group>
                <Input {...register('angle')} title='Ângulo' />
                <Input {...register('x', { required: true })} title='X' name='x' />
                <Input {...register('y', { required: true })} title='Y' name='y' />
            </Group>
            <Button>Executar</Button>
        </Form>
    );
}
