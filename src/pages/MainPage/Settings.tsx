import { useEffect } from 'react';
import { useForm } from 'react-hook-form';
import { Form } from '../../components/Form';
import { Range } from '../../components/Range';
import { Select } from '../../components/Select';
import { useRadarStore } from '../../integrations/radar/radarStore';

type fieldsType = {
    readonly radarView: 'polar' | 'cartesian';
    readonly numberOfParts: number;
};

export function Settings() {
    const setNumberOfParts = useRadarStore(state => state.setNumberOfParts);
    const setRadarView = useRadarStore(state => state.setRadarView);
    const { register, watch } = useForm<fieldsType>({
        defaultValues: {
            radarView: 'cartesian',
            numberOfParts: 20,
        },
    });

    useEffect(() => {
        const subscription = watch(({ numberOfParts, radarView }) => {
            if (numberOfParts)
                setNumberOfParts(numberOfParts);
            if (radarView)
                setRadarView(radarView);
        });
        return () => subscription.unsubscribe();
    }, [watch, setNumberOfParts, setRadarView]);

    return (
        <div>
            <Form name='Configurações' onSubmit={e => e.preventDefault()}>
                <Select
                    {...register('radarView')}
                    title='Estilo do radar'
                    options={[
                        { name: 'polar', label: 'Polar' },
                        { name: 'cartesian', label: 'Cartesiano' },
                    ]}
                />
                <Range
                    {...register('numberOfParts', { valueAsNumber: true, min: 2, max: 50 })}
                    title='Número de partes'
                />
            </Form>
        </div>
    );
}
