import classNames from 'classnames';
import Modal from 'react-modal';
import { GrFormClose } from 'react-icons/gr';
import { airplaneType } from '../features/airplane/models';

type propsType = {
    readonly airplane: airplaneType | undefined;
    readonly close: () => void;
}

const customStyles = {
    content: {
        width: '75%',
        top: '50%',
        left: '50%',
        right: 'auto',
        bottom: 'auto',
        marginRight: '-50%',
        transform: 'translate(-50%, -50%)',
    },
};

Modal.setAppElement('#root');

export function AirplaneModal({
    airplane,
    close,
}: propsType) {
    function getLabelByType(cartesianLabel: string, polarLabel: string) {
        switch (airplane?.planePoint.planeType) {
            case 'CARTESIAN':
                return cartesianLabel;
            case 'POLAR':
                return polarLabel;
            default:
                return '';
        }
    }

    return (
        <Modal
            isOpen={!!airplane}
            onRequestClose={close}
            style={customStyles}
        >
            <div className='flex justify-end pb-4'>
                <button
                    className={classNames(
                        'p-2 rounded border-2',
                        'bg-red-500 border-transparent',
                        'hover:bg-red-400 hover:border-red-500',
                        'active:bg-red-400 active:border-red-500',
                    )}
                    onClick={close}
                >
                    <GrFormClose className='fill-white' />
                </button>
            </div>
            <div className='flex-row'>
                <div className='flex px-2 py-1 bg-slate-100'>
                    <div className="text-lg w-1/5">Id</div>
                    <div>{airplane?.id}</div>
                </div>
                <div className='flex px-2 py-1'>
                    <div className="text-lg w-1/5">Coordenadas</div>
                    <div>{getLabelByType('Cartesianas', 'Polares')}</div>
                </div>
                <div className='flex px-2 py-1 bg-slate-100'>
                    <div className="text-lg w-1/5">{getLabelByType('X', 'Raio')}</div>
                    <div>{airplane?.planePoint.a}</div>
                </div>
                <div className='flex px-2 py-1'>
                    <div className="text-lg w-1/5">{getLabelByType('Y', 'Ângulo')}</div>
                    <div>{airplane?.planePoint.b}</div>
                </div>
                <div className='flex px-2 py-1 bg-slate-100'>
                    <div className="text-lg w-1/5">Direção</div>
                    <div>{airplane?.vector.direction}</div>
                </div>
                <div className='flex px-2 py-1'>
                    <div className="text-lg w-1/5">Velocidade</div>
                    <div>{airplane?.vector.speed}</div>
                </div>
            </div>
        </Modal>
    );
}
