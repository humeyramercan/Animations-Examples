package com.humeyramercan.animationexamples

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import com.humeyramercan.animationexamples.databinding.FragmentViewAnimationsBinding

class TweenAnimationsFragment : Fragment(), View.OnClickListener {
    private lateinit var binding:FragmentViewAnimationsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentViewAnimationsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.alphaButton.setOnClickListener(this)
        binding.rotateButton.setOnClickListener(this)
        binding.scaleZoomInButton.setOnClickListener(this)
        binding.scaleZoomOutButton.setOnClickListener(this)
        binding.translateFromDownBtn.setOnClickListener(this)
        binding.translateFromUpBtn.setOnClickListener(this)
        binding.translateFromLeftBtn.setOnClickListener(this)
        binding.translateFromRightBtn.setOnClickListener(this)
        binding.mixedAnimButton.setOnClickListener(this)
        binding.goToFrameAnimationsBtn.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            binding.alphaButton.id->{
               startAnimation(binding.alphaText,R.anim.alpha)
            }
            binding.rotateButton.id->{
                startAnimation(binding.rotateText,R.anim.rotate)
            }
            binding.scaleZoomInButton.id->{
                startAnimation(binding.scaleZoomInText,R.anim.scale_zoom_in)
            }
            binding.scaleZoomOutButton.id->{
                startAnimation(binding.scaleZoomOutText,R.anim.scale_zoom_out)
            }
            binding.translateFromDownBtn.id->{
                startAnimation(binding.translateFromDownTxt,R.anim.translate_from_down)
            }
            binding.translateFromUpBtn.id->{
                startAnimation(binding.translateFromUpTxt,R.anim.translate_from_up)
            }
            binding.translateFromLeftBtn.id->{
                startAnimation(binding.translateFromLeftTxt,R.anim.translate_from_left)
            }
            binding.translateFromRightBtn.id->{
                startAnimation(binding.translateFromRightTxt,R.anim.translate_from_right)
            }
            binding.mixedAnimButton.id->{
                startAnimation(binding.mixedAnimText,R.anim.mixed)
            }
            binding.goToFrameAnimationsBtn.id->{
                val action=TweenAnimationsFragmentDirections.actionViewAnimationsFragmentToFrameAnimationFragment()
                findNavController().navigate(action)
            }
        }
    }

    private fun startAnimation(view:View,anim:Int){
        val animation: Animation = AnimationUtils.loadAnimation(activity,anim)
        view.startAnimation(animation)
    }

}