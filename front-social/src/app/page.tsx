import { CircleUserRound, Clock, User } from "lucide-react";
import Image from "next/image";

export default function Home() {

  const Comentarios = [
    {
      avatar: <CircleUserRound size={48} strokeWidth={1} color="gray"/>,
      nome: "Alana Abreu",
      horario: "há 30 minutos",
      descricao: "Ótimo passeio hoje, hein?  Volte mais vezes! 👏",
    },
    {
      avatar: <CircleUserRound size={48} strokeWidth={1} color="gray"/>,
      nome: "Rafael Argolo",
      horario: "há 3 horas",
      descricao: "Que bonito, sobrinho!",
    }
  ]


  return (
    <div className="bg-white mt-4 flex justify-start w-5xl">
      <div className="flex flex-col">
        {/* Informações do usuario */}
        <div className="bg-violet-500 h-16 mt-8 flex w-2xs p-4 text-white [clip-path:polygon(0_0,100%_0,90%_100%,0_100%)]">
          Informações do usuario
        </div>
        {/* Publicação do usuario */}
        <div className="bg-gray-300 ml-6 my-6 p-4 w-lg rounded-sm ">
          <p>
            A visita hoje foi no parque internacional da Itália e foi muito proveitoso, muito bonito! Mais tarde fomos para o...
          </p>
        </div>
        {/* Comentarios */}
        <div className="  bg-gray-300 py-8 pr-8 text-black rounded-r-sm  w-md  ">
          <div className=" rounded-sm w-full bg-white h-full overflow-hidden">
            {Comentarios.map((comentario, index) => (
              <div key={index} className="border-b border-gray-200 rounded-sm  p-4">
                <div className="flex ">
                  <div className="mr-3">
                    {comentario.avatar}
                  </div>
                  <div className="flex flex-col">
                    <p className="font-semibold">{comentario.nome}</p>
                    <div className="flex flex-row justify-center items-center gap-1">
                      <Clock size={16}/>
                      <span className="italic">{comentario.horario}</span>
                    </div>
                  </div>
                </div>
                <p className="text-gray-600 ml-3">{comentario.descricao}</p>
              </div>
            ))}
          </div>
        </div>
      </div>

      {/* Imagem da publicação do usuario */}
      <div className="mt-24 overflow-hidden rounded-sm bg-amber-800 w-lg h-[500px] mr-8 relative">
        <Image 
          src={"/image.png"}
          alt="Imagem teste"
          fill
          className="object-cover"
          
        />
      </div>
    </div>
  );
}
