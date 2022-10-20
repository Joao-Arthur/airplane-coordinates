import { useForm } from 'react-hook-form';
import { Button } from '../components/Button';
import { Form } from '../components/Form';
import { Group } from '../components/Group';
import { Input } from '../components/Input';
import { useAirplaneStore } from '../integrations/airplane/airplanesStore';
import { useAirplanes } from '../integrations/airplane/useAirplanes';

type fieldsType = {
    readonly angle: number;
    readonly centerOfRotationX: number;
    readonly centerOfRotationY: number;
}

export function Rotate() {
    const { register, handleSubmit } = useForm<fieldsType>({
        defaultValues: {
            angle: 0,
            centerOfRotationX: 0,
            centerOfRotationY: 0,
        },
    });
    const { rotateCoordinates } = useAirplanes();
    const selectedIds = useAirplaneStore(state => state.selectedAirplanes);

    function onHandleSubmit({ angle, centerOfRotationX, centerOfRotationY }: fieldsType) {
        rotateCoordinates({ selectedIds, angle, centerOfRotationX, centerOfRotationY });
    }

    return (
        <Form name='Rotacionar' onSubmit={handleSubmit(onHandleSubmit)}>
            <Group>
                <Input {...register('angle', { valueAsNumber: true })} title='Ângulo' />
                <Input {...register('centerOfRotationX', { valueAsNumber: true, required: true })} title='X' name='centerOfRotationX' />
                <Input {...register('centerOfRotationY', { valueAsNumber: true, required: true })} title='Y' name='centerOfRotationY' />
            </Group>
            <Button>Executar</Button>
        </Form>
    );
}
