import { ReactNode, useState } from "react";
import classnames from 'classnames';

type props = {
    tabs: {
        title: string;
        comp: ReactNode;
    }[];
}

export function Tab({ tabs }: props) {
    const [active, setActive] = useState(tabs[0].title);

    const current = tabs.find(tab => tab.title === active)!.comp;

    return (
        <>
            <div className="flex text-sm font-medium border-b border-gray-100" >
                {tabs.map(({ title }) => (
                    <div
                        key={title}
                        className={classnames(
                            "p-4 -mb-px border-b text-cyan-500 cursor-pointer",
                            title === active ? 'border-current' : 'border-transparent'
                        )}
                        onClick={() => setActive(title)}
                    >
                        {title}
                    </div>
                ))}
            </div>
            {current}
        </>
    );
}