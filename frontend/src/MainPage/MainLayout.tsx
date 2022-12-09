
import { useRef, useState } from 'react';
import { useDidMount } from 'rooks';
import { numbers } from 'funis';
import { Tab } from '../components/Tab';
import { AddAirplane } from './AddAirplane';
import { DeleteAirplane } from './DeleteAirplane';
import { AirplanesTable } from './AirplanesTable';
import { CloseToAirport } from './CloseToAirport';
import { CloseToEachOther } from './CloseToEachOther';
import { InRouteOfCollision } from './InRouteOfCollision';
import { Radar } from './Radar';
import { Report } from './Report';
import { Rotate } from './Rotate';
import { Scalonate } from './Scalonate';
import { Translate } from './Translate';
import { Settings } from './Settings';

export function MainLayout() {
    const radarContainer = useRef<HTMLDivElement | null>(null);
    const [dimensions, setDimensions] = useState(0);

    function resize() {
        const width = radarContainer?.current?.clientWidth || 0;
        const height = radarContainer?.current?.clientHeight || 0;

        setDimensions(
            numbers.clamp(Math.min(width, height) - 50, { min: 0 }),
        );
    }

    useDidMount(() => {
        resize();
        window.addEventListener('resize', resize);
        return () => window.removeEventListener('resize', resize);
    });

    return (
        <>
            <div className='flex flex-col w-1/3 pl-1'>
                <Tab
                    tabs={[
                        {
                            title: 'Listagem',
                            comp: (
                                <div>
                                    <AddAirplane />
                                    <DeleteAirplane />
                                </div>
                            ),
                        },
                        {
                            title: 'Transformar',
                            comp: (
                                <div>
                                    <Translate />
                                    <Scalonate />
                                    <Rotate />
                                </div>
                            ),
                        },
                        {
                            title: 'Rastrear',
                            comp: (
                                <div>
                                    <CloseToAirport />
                                    <CloseToEachOther />
                                    <InRouteOfCollision />
                                </div>
                            ),
                        },
                        {
                            title: 'Configurações',
                            comp: (
                                <Settings />
                            ),
                        },
                    ]}
                />
            </div>
            <div className='flex flex-col w-1/3' ref={radarContainer}>
                <Radar dimensions={dimensions} />
            </div>
            <div className='flex flex-col w-1/3 h-full'>
                <AirplanesTable />
                <Report />
            </div>
        </>
    );
}
