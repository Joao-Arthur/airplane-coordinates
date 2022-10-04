import { Button } from '../../components/Button';
import { Form } from '../../components/Form';
import { useAirplaneStore } from '../../integrations/airplane/airplanesStore';
import { useAirplanes } from '../../integrations/airplane/useAirplanes';

export function DeleteAirplane() {
    const { deleteAiplanes } = useAirplanes();
    const selectedIds = useAirplaneStore(state => state.selectedAirplanes);

    function onClick() {
        deleteAiplanes({ selectedIds });
    }

    return (
        <Form name='Deletar' onSubmit={e => { e.preventDefault(); onClick(); }}>
            <Button title='Deletar aviões selecionados' />
        </Form>
    );
}
