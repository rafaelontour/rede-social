import { Search } from "lucide-react";

export default function BarraDePesquisa() {
    return (
        <div className="bg-gray-300 flex rounded-sm h-10 justify-between items-center p-4 w-80">
            <input 
                type="text" 
                placeholder="Pesquise por pessoas aqui.."   
                className="w-full"
            />
            <Search size={18}/>
        </div>
    )
}