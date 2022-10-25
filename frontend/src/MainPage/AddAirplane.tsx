import { useForm } from 'react-hook-form';
import { Button } from '../components/Button';
import { Form } from '../components/Form';
import { Group } from '../components/Group';
import { Input } from '../components/Input';
import { Select } from '../components/Select';
import { useAirplanes } from '../integrations/airplane/useAirplanes';

type fieldsType = {
    readonly x: number;
    readonly y: number;
    readonly radius: number;
    readonly angle: number;
    readonly speed: number;
    readonly direction: number;
    readonly coordinatesType: 'cartesian' | 'polar';
}

export function AddAirplane() {
    const { add } = useAirplanes();
    const { register, handleSubmit, watch } = useForm<fieldsType>({
        defaultValues: {
            x: 0,
            y: 0,
            radius: 0,
            angle: 0,
            speed: 0,
            direction: 0,
            coordinatesType: 'cartesian',
        },
    });

    function onHandleSubmit({ speed, direction, x, y, radius, angle, coordinatesType }: fieldsType) {
        add({
            airplaneParams: {
                speed,
                direction,
                type: coordinatesType,
                a: coordinatesType === 'cartesian' ? String(x) : String(radius),
                b: coordinatesType === 'cartesian' ? String(y) : String(angle),
            },
        });
    }

    return (
        <Form name='Adicionar' onSubmit={handleSubmit(onHandleSubmit)}>
            <Select
                {...register('coordinatesType')}
                title='Coordenadas'
                options={[
                    { name: 'polar', label: 'Polares' },
                    { name: 'cartesian', label: 'Cartesianas' },
                ]}
            />
            <Group>
                {watch('coordinatesType') === 'cartesian' ? (
                    <>
                        <Input {...register('x', { valueAsNumber: true, required: true })} title='X' key='x' />
                        <Input  {...register('y', { valueAsNumber: true, required: true })} title='Y' key='y' />
                    </>
                ) : (
                    <>
                        <Input {...register('radius', { valueAsNumber: true, required: true })} title='Raio' key='radius' />
                        <Input {...register('angle', { valueAsNumber: true, required: true })} title='Ângulo' key='angle' />
                    </>
                )}
                <Input {...register('speed', { valueAsNumber: true, required: true })} title='Velocidade' />
                <Input {...register('direction', { valueAsNumber: true, required: true })} title='Direção' />
            </Group>
            <Button>Adicionar</Button>
        </Form>
    );
}
